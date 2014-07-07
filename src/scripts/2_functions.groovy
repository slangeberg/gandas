import static com.greekadonis.gandas.DataFrame.*

import com.greekadonis.gandas.DataFrame
import org.apache.commons.lang3.time.StopWatch

///////////////////////////////////////////

println "2. Functions"
println "==========================="

StopWatch timer = new StopWatch()
timer.start()

def df = new DataFrame([
    one: [1, 2, 3],
    two: [1, 2, 3, 4]
])

println "df: $df"

println "df.apply(mean): ${df.apply(mean)}"

println "==========================="
println "Total time: ${timer.time}ms"