import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.request.post
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.gradle.api.Plugin
import org.gradle.api.Project

import org.gradle.kotlin.dsl.*
import java.net.URL

class GreetPlugin : Plugin<Project> {

    override fun apply(project: Project): Unit = project.run {

//        tasks {
//            register("greet") {
//                group = "sample"
//                description = "Prints a description of ${project.name}."
//                doLast {
//                    println("I'm ${project.name}.")
//                }
//            }
//        }
//
       val client = HttpClient(OkHttp)

        GlobalScope.launch {
            val response = client.post<String>(URL("http://google.com")) {
                body = "ddddd"
                build()
            }
            if (response.isNotEmpty()) {

            }
        }
    }
}