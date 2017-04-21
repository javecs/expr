package xyz.javecs.tools.expr

import xyz.javecs.tools.expr.parser.ExprBaseVisitor
import xyz.javecs.tools.expr.parser.ExprParser

internal class EvalVisitor(val context: EvalContext) : ExprBaseVisitor<Expression>() {
    override fun visitParens(ctx: ExprParser.ParensContext?) = visit(ctx!!.expr())!!
    override fun visitNumber(ctx: ExprParser.NumberContext?) = Expression(ctx!!.NUMBER().text.toDouble())
    override fun visitAdd(ctx: ExprParser.AddContext?) = Expression(visit(ctx!!.expr(0)).value + visit(ctx.expr(1)).value)
    override fun visitSub(ctx: ExprParser.SubContext?) = Expression(visit(ctx!!.expr(0)).value - visit(ctx.expr(1)).value)
    override fun visitMul(ctx: ExprParser.MulContext?) = Expression(visit(ctx!!.expr(0)).value * visit(ctx.expr(1)).value)
    override fun visitMod(ctx: ExprParser.ModContext?) = Expression(visit(ctx!!.expr(0)).value % visit(ctx.expr(1)).value)
    override fun visitPow(ctx: ExprParser.PowContext?) = Expression(Math.pow(visit(ctx!!.expr(0)).value, visit(ctx.expr(1)).value))
    override fun visitSign(ctx: ExprParser.SignContext?): Expression {
        val value = visit(ctx!!.expr()).value
        return Expression(when (ctx.start.text) {
            "-" -> value * -1
            else -> value
        })
    }

    override fun visitDiv(ctx: ExprParser.DivContext?): Expression {
        val left = visit(ctx!!.expr(0)).value
        val right = visit(ctx.expr(1)).value
        return if (right == 0.0) Expression(Double.NaN) else Expression(left / right)
    }

    override fun visitId(ctx: ExprParser.IdContext?): Expression {
        val id = ctx!!.ID().text
        return Expression(id = id, value = context.get(id))
    }

    override fun visitAssign(ctx: ExprParser.AssignContext?): Expression {
        val id = ctx!!.ID().text
        val value = visit(ctx.expr()).value
        return Expression(id = id, value = context.put(id, value))
    }

    override fun visitFunction(ctx: ExprParser.FunctionContext?): Expression {
        val func = ctx!!.ID().text
        val args = ArrayList<Double>()
        ctx.expr().mapTo(args) { visit(it).value }
        return Expression(value = context.call(func, args.toTypedArray()))
    }

    override fun visitConstant(ctx: ExprParser.ConstantContext?): Expression {
        val name = ctx!!.CONSTANT().text
        return Expression(value = context.get(name))
    }
}