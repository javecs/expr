package xyz.javecs.tools.expr

import xyz.javecs.tools.expr.parser.ExprBaseVisitor
import xyz.javecs.tools.expr.parser.ExprParser

class EvalVisitor : ExprBaseVisitor<Double>() {
    override fun visitParens(ctx: ExprParser.ParensContext?) = visit(ctx!!.expr())!!
    override fun visitNumber(ctx: ExprParser.NumberContext?) = ctx!!.NUMBER().text.toDouble()
    override fun visitAdd(ctx: ExprParser.AddContext?) = visit(ctx!!.expr(0)) + visit(ctx.expr(1))
    override fun visitSub(ctx: ExprParser.SubContext?) = visit(ctx!!.expr(0)) - visit(ctx.expr(1))
    override fun visitMul(ctx: ExprParser.MulContext?) = visit(ctx!!.expr(0)) * visit(ctx.expr(1))
    override fun visitMod(ctx: ExprParser.ModContext?) = visit(ctx!!.expr(0)) % visit(ctx.expr(1))
    override fun visitPow(ctx: ExprParser.PowContext?) = Math.pow(visit(ctx!!.expr(0)), visit(ctx.expr(1)))
    override fun visitDiv(ctx: ExprParser.DivContext?): Double {
        val left = visit(ctx!!.expr(0))
        val right = visit(ctx.expr(1))
        return if (right == 0.0) Double.NaN else left / right
    }
}