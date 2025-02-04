package dev.dokup.webviewtest

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  companion object {
    private const val ITEM_TYPE_TEXT = 1
    private const val ITEM_TYPE_WEBVIEW = 2
    private const val INDEX_WEB_VIEW = 5
    private const val ITEM_COUNT = 11
  }

  // その名の通りViewHolderを作成。MainViewHolderの引数にinflateしたレイアウトを入れている
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    if (viewType == ITEM_TYPE_TEXT) {
      val textItemView = LayoutInflater
        .from(parent.context)
        .inflate(R.layout.text_item_layout, parent, false)
      return TextItemViewHolder(textItemView)
    } else if (viewType == ITEM_TYPE_WEBVIEW) {
      val webViewItemView = LayoutInflater
        .from(parent.context)
        .inflate(R.layout.webview_item_layout, parent, false)
      return WebViewViewHolder(webViewItemView)
    } else {
      throw IllegalStateException("Unexpected view type")
    }
  }

  override fun getItemViewType(position: Int): Int {
    return if (position == INDEX_WEB_VIEW) {
      ITEM_TYPE_WEBVIEW
    } else {
      ITEM_TYPE_TEXT
    }
  }

  // ViewHolder内に表示するデータを指定。
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    if (holder is WebViewViewHolder) {
      val webView = holder.itemView.findViewById<WebView>(R.id.web_view)
      webView.loadUrl("https://e10dokup.pecori.jp/backdrop/")
    }
  }

  // 表示したいリストの数を指定
  override fun getItemCount(): Int {
    return ITEM_COUNT
  }
}
