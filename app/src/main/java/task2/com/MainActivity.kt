
@file:Suppress("DEPRECATION")

package task2.com
import kotlin.random.Random
import android.annotation.SuppressLint
import android.graphics.Color.BLUE
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.graphics.Color.WHITE
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("MoveVariableDeclarationIntoWhen")
class MainActivity : AppCompatActivity() {
    private lateinit var TextV:TextView
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        TextV=findViewById(R.id.edittext)
        button=findViewById(R.id.button)
        registerForContextMenu(TextV)

        onButtonClick(button)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menucontext,menu)
    }

    @SuppressLint("ResourceAsColor")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_change_color ->{
                val estimation=TextV.text.toString().toInt()
                when (estimation){
                    in (1..10) -> {
                        TextV.setBackgroundColor(RED)
                        Toast.makeText(this,"меняем цвет на КРАСНЫЙ",Toast.LENGTH_LONG).show()
                    }
                    in (11..20) -> {
                        TextV.setBackgroundColor(resources.getColor(R.color.orange1))
                        Toast.makeText(this,"меняем цвет на ОРАНЖЕВЫЙ",Toast.LENGTH_LONG).show()
                    }
                    in (21..30) -> {
                        TextV.setBackgroundColor(resources.getColor(R.color.yellow2))
                        Toast.makeText(this,"меняем цвет на ЖЕЛТЫЙ",Toast.LENGTH_LONG).show()
                    }
                    in(31..40) -> {
                        TextV.setBackgroundColor(GREEN)
                        Toast.makeText(this,"меняем цвет на ЗЕЛЕНЫЙ",Toast.LENGTH_LONG).show()
                    }
                    in (41..50) -> {
                        TextV.setBackgroundColor(BLUE)
                        Toast.makeText(this,"меняем цвет на СИНИЙ",Toast.LENGTH_LONG).show()
                    }

                }


            }
            R.id.menu_exit_program ->{
                finish()
                Toast.makeText(this,"выход из программы",Toast.LENGTH_LONG).show()

            }
            else -> return super.onContextItemSelected(item)
        }

        return true
    }
    fun onButtonClick(view: View){
        val randomNumber = generateRandomNumber()
        TextV.text=randomNumber.toString()

    }
    fun generateRandomNumber(): Int {
        return Random.nextInt(1, 51)
    }

}
