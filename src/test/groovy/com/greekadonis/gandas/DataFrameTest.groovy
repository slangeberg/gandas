package com.greekadonis.gandas

import org.apache.commons.lang3.time.StopWatch

import static DataFrame.*

import spock.lang.Specification

/**
 * Created by scott on 7/5/14.
 */
class DataFrameTest extends Specification {

  def "Can load lots of data"(){

    int numEls = 1000000
    def colOneValues = []
    def colTwoValues = []
    (1..numEls).each {
      colOneValues << it
      colTwoValues << (it * 2)
    }
    def params = [
        one: colOneValues,
        two: colTwoValues
    ]

    ////////

    StopWatch timer = new StopWatch()
    timer.start()

    DataFrame df = new DataFrame(params)
    def result = df.apply(mean)

    println "\nCompleted w/#els: $numEls, in ${timer.time}ms"

    ////////

    def expectedOne = colOneValues.sum()/colOneValues.size()
    def expectedTwo = colTwoValues.sum()/colTwoValues.size()

    expect:
      result.one == expectedOne
      result.two == expectedTwo
  }
}
