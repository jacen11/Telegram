package dev.pastukhov.telegram

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import dev.pastukhov.telegram.databinding.ActivityMainBinding
import dev.pastukhov.telegram.ui.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(toolbar)
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {

        val settingsItem = PrimaryDrawerItem()
            .withIdentifier(106)
            .withIconTintingEnabled(true)
            .withName("Настройки")
            .withSelectable(false)
            .withIcon(R.drawable.ic_menu_settings)

        val menuItems = arrayOf(
            PrimaryDrawerItem()
                .withIdentifier(100)
                .withIconTintingEnabled(true)
                .withName("Создать группу")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_create_groups),
            PrimaryDrawerItem()
                .withIdentifier(101)
                .withIconTintingEnabled(true)
                .withName("Создать секретный чат")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_secret_chat),
            PrimaryDrawerItem().withIdentifier(102)
                .withIconTintingEnabled(true)
                .withName("Создать канал")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_create_channel),
            PrimaryDrawerItem().withIdentifier(103)
                .withIconTintingEnabled(true)
                .withName("Контакты")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_contacts),
            PrimaryDrawerItem().withIdentifier(104)
                .withIconTintingEnabled(true)
                .withName("Звонки")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_phone),
            PrimaryDrawerItem().withIdentifier(105)
                .withIconTintingEnabled(true)
                .withName("Избранное")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_favorites),
            settingsItem,
            PrimaryDrawerItem().withIdentifier(107)
                .withIconTintingEnabled(true)
                .withName("Создать группу")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_create_groups),
            DividerDrawerItem(),
            PrimaryDrawerItem().withIdentifier(108)
                .withIconTintingEnabled(true)
                .withName("Пригласить друзей")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_invate),
            PrimaryDrawerItem().withIdentifier(109)
                .withIconTintingEnabled(true)
                .withName("Вопросы о телеграм")
                .withSelectable(false)
                .withIcon(R.drawable.ic_menu_help)
        )

        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems(*menuItems)
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {

                    when (drawerItem) {
                        settingsItem -> {
                            supportFragmentManager.beginTransaction()
                                .addToBackStack(null)
                                .replace(R.id.dataContainer, SettingsFragment()).commit()
                        }
                    }

                    Toast.makeText(applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
                    return false
                }
            }).build()
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Zadov")
                    .withEmail("iuashgi@udsfg.com")
            ).build()
    }

    private fun initFields() {
        toolbar = binding.mainToolbar


    }
}
