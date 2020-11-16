package com.example.broadcastbestpractice

import android.app.Activity

/**
 * Activity管理器
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    /**
     * 添加指定得Activity
*/
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }
    /**
     * 移除指定得Activity
     */
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    /**
     * 销毁所有的Activity
     */
    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }
}