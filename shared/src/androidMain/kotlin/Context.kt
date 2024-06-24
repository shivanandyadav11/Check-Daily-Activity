import android.content.Context

object Context {
    var _context: Context? = null
    fun init(context: Context) {
        _context = context
    }
}