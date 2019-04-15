import dagger.Component
import javax.inject.Inject

class HiDecorator @Inject constructor(val info: Info){
    fun decorate():String{
        return "Hi  ${info.text}"
    }
}

class Info @Inject constructor(){
    var text =""
    init{
        text="Dummy text"
    }
}


@Component
interface AppComponent {
    fun getHiDecorator():HiDecorator
}

class MainClass{
    var decorator: HiDecorator = DaggerAppComponent.create().getHiDecorator()
    fun present()=println(decorator.decorate())
}

fun main() {
   MainClass().present()
}
