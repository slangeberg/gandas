package com.greekadonis.gandas

import com.greekadonis.gandas.DataFrame
import org.apache.commons.lang3.time.StopWatch
import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

import static com.greekadonis.gandas.DataFrame.getMean

class DataFramePerfTest extends Specification {

  int numEls = 1000000
  def colOneValues = []
  def colTwoValues = []
  def params = [:]

  def setup() {
    (1..numEls).each {
      colOneValues << it
      colTwoValues << (it * 2)
    }
    params = [
        one: colOneValues,
        two: colTwoValues
    ]
  }

  def "Average time time to apply mean is below threshold"(){

    ////////

    int iterations = 10

    StopWatch timer = new StopWatch()
    timer.start()

    (1..iterations).each {
      DataFrame df = new DataFrame(params)
      def result = df.apply(DataFrame.mean)
//      println "\nCompleted w/#els: $numEls, in ${timer.time}ms"
    }

    int average = timer.time / iterations

    ////////

    expect:
      average <= 280
  }
}
