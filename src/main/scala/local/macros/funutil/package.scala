package local.macros

package object funutil {

  import monocle.PLens

  @inline implicit class FunctionOps[S, T](f: Function[S, T]) {
    @inline def $(s: S): T = f.apply(s)
  }

  @inline implicit class PLensOps[S, T, A, B](plens: PLens[S, T, A, B]) {
    @inline def ~[C, D](that: PLens[A, B, C, D]): PLens[S, T, C, D] =
      plens.composeLens(that)
  }
}
