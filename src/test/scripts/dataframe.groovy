import com.greekadonis.gandas.DataFrame
import org.apache.commons.lang3.time.StopWatch

StopWatch timer = new StopWatch()
timer.start()

def df = new DataFrame([
    name: ["Braund", "Cummings", "Johnson"],
    age: [22, 38],
    fare: [7.25, 71.38, 55.25],
    survived: [false, true]
])

println "df: $df"

println "df.age: ${df.age}"

println "df.loc(0): ${df.loc(0)}"
println "df.loc(1): ${df.loc(1)}"

println "==========================="
println "Total time: ${timer.time}ms"