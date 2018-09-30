package cn.dev.knowall.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cn.dev.knowall.R
import cn.dev.knowall.fragment.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_case.*

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case)
        setSupportActionBar(mToolbar)
        val title = intent.getStringExtra(TITLE)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = title
        Glide.with(this).load(intent.getIntExtra(IMG_ID, 0)).into(iv_header)
        when (title) {
            getString(R.string.deposit) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, DepositFragment()).commit()
            getString(R.string.mobile) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, PhoneFragment()).commit()
            getString(R.string.postcode) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, PostCodeFragment()).commit()
            getString(R.string.weather) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, WFragment()).commit()
            getString(R.string.train) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, BFragmentA()).commit()
            getString(R.string.flight) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, BFragmentB()).commit()
            getString(R.string.sudoku) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, CFragmentA()).commit()
            getString(R.string.snake) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, CFragmentB()).commit()
            getString(R.string.look) -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_F, CFragmentC()).commit()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val IMG_ID = "IMG_ID"
        const val TITLE = "TITLE"
    }
}
