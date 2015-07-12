import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import play.api.{Application, GlobalSettings}

/**
 * Created by gabbi on 12/07/15.
 */
object Global extends GlobalSettings{
  private val applicationContext: ClassPathXmlApplicationContext = new ClassPathXmlApplicationContext("springContext.xml")

  override def onStop(app: Application): Unit = {
    applicationContext.stop()
    super.onStop(app)
  }

  override def getControllerInstance[A](controllerClass: Class[A]): A = {
    println(s"creating controller instance of class ${controllerClass.getName}")
    applicationContext.getBean(controllerClass)
  }
}
