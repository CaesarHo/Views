package com.caesar.ho.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.caesar.ho.R
import com.caesar.ho.view.BatteryView
import java.util.*


class BatteryActivity : AppCompatActivity() {

    private var horizontalBattery: BatteryView? = null
    private var verticalBattery:BatteryView? = null
    private var power: Int = 0
    private var index: Int = 5;
    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                0 -> {
                    power += 5
                    horizontalBattery!!.power = power
                    if (power == 100) {
                        power = 0
                    }
                }
                else -> {
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery)

        horizontalBattery = findViewById(R.id.horizontalBattery) as BatteryView
        verticalBattery = findViewById(R.id.verticalBattery) as BatteryView

        verticalBattery!!.setColor(Color.BLACK)
        verticalBattery!!.setPower(85)

        Timer().schedule(object : TimerTask() {
            override
            fun run() {
                mHandler.sendEmptyMessage(0)
            }
        }, 0, 100)
    }
}
