package com.greekadonis.gandas

import org.apache.commons.lang3.time.StopWatch

import static DataFrame.*

import spock.lang.Specification

/**
 * Created by scott on 7/5/14.
 */
class DataFrameTest extends Specification {
  def "Can load lots of data"(){

    StopWatch timer = new StopWatch()
    timer.start()

    int numEls = 1000000
    def colOneValues = []
    def colTwoValues = []
    (1..numEls).each {
      colOneValues << it
      colTwoValues << it * 2
    }
    def params = [
        one: colOneValues,
        two: colTwoValues
    ]

    DataFrame df = new DataFrame(params)
    def result = df.apply(mean)

    println "\nCompleted w/#els: $numEls, in ${timer.time}ms"

    expect:
      result.one == colOneValues.sum()/colOneValues.size()
      result.two == colOneValues.sum()/colOneValues.size()
  }
}
