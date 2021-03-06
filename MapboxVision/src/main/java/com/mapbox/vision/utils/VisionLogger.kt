package com.mapbox.vision.utils

import android.annotation.SuppressLint
import android.util.Log
import com.mapbox.vision.BuildConfig

interface VisionLogger {

    fun v(tag: String, message: String)

    fun v(t: Throwable, tag: String, message: String)

    fun d(tag: String, message: String)

    fun d(t: Throwable, tag: String, message: String)

    fun i(tag: String, message: String)

    fun i(t: Throwable, tag: String, message: String)

    fun w(tag: String, message: String)

    fun w(t: Throwable, tag: String, message: String)

    fun e(tag: String, message: String)

    fun e(t: Throwable, tag: String, message: String)

    companion object {
        private var DEFAULT_LOGGER: VisionLogger = VisionLogger.Impl(if (BuildConfig.DEBUG) Log.DEBUG else Log.INFO)

        fun setLogger(visionLogger: VisionLogger) {
            DEFAULT_LOGGER = visionLogger
        }

        fun v(tag: String, message: String) {
            DEFAULT_LOGGER.v(tag, message)
        }

        fun v(t: Throwable, tag: String, message: String) {
            DEFAULT_LOGGER.v(t, tag, message)
        }

        fun d(tag: String, message: String) {
            DEFAULT_LOGGER.v(tag, message)
        }

        fun d(t: Throwable, tag: String, message: String) {
            DEFAULT_LOGGER.v(t, tag, message)
        }

        fun i(tag: String, message: String) {
            DEFAULT_LOGGER.v(tag, message)
        }

        fun i(t: Throwable, tag: String, message: String) {
            DEFAULT_LOGGER.v(t, tag, message)
        }

        fun w(tag: String, message: String) {
            DEFAULT_LOGGER.v(tag, message)
        }

        fun w(t: Throwable, tag: String, message: String) {
            DEFAULT_LOGGER.v(t, tag, message)
        }

        fun e(tag: String, message: String) {
            DEFAULT_LOGGER.v(tag, message)
        }

        fun e(t: Throwable, tag: String, message: String) {
            DEFAULT_LOGGER.v(t, tag, message)
        }
    }

    private class Impl(private val minLogLevel: Int = Log.INFO) : VisionLogger {

        private fun isLoggable(logLevel: Int): Boolean {
            return logLevel >= minLogLevel
        }

        @SuppressLint("LogTagMismatch")
        override fun v(tag: String, message: String) {
            if (isLoggable(Log.VERBOSE)) {
                Log.v(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun v(t: Throwable, tag: String, message: String) {
            if (isLoggable(Log.VERBOSE)) {
                Log.v(tag, message, t)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun d(tag: String, message: String) {
            if (isLoggable(Log.DEBUG)) {
                Log.d(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun d(t: Throwable, tag: String, message: String) {
            if (isLoggable(Log.DEBUG)) {
                Log.d(tag, message, t)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun i(tag: String, message: String) {
            if (isLoggable(Log.INFO)) {
                Log.i(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun i(t: Throwable, tag: String, message: String) {
            if (isLoggable(Log.INFO)) {
                Log.i(tag, message, t)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun w(tag: String, message: String) {
            if (isLoggable(Log.WARN)) {
                Log.w(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun w(t: Throwable, tag: String, message: String) {
            if (isLoggable(Log.WARN)) {
                Log.w(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun e(tag: String, message: String) {
            if (isLoggable(Log.ERROR)) {
                Log.e(tag, message)
            }
        }

        @SuppressLint("LogTagMismatch")
        override fun e(t: Throwable, tag: String, message: String) {
            if (isLoggable(Log.ERROR)) {
                Log.e(tag, message, t)
            }
        }
    }
}
