package cc.changliu.pokerman;

import android.annotation.SuppressLint
import android.app.Application;
import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;

class MainApp : Application(), DefaultLifecycleObserver {
    override fun onCreate() {
        super < Application >.onCreate()
        context = applicationContext

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        @JvmStatic
        fun getContext(): Context = context!!
    }
}
