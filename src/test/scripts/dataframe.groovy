import com.greekadonis.gandas.DataFrame

def df = new DataFrame(
    name: ["Braund", "Cummings"],
    age: [22, 38],
    fare: [7.25, 71.38],
    survived: [false, true]
)

println "df: $df"
println "df.toString(): ${df.toString()}"

println "df.age: ${df.age}"



