package com.greekadonis.gandas

import org.apache.commons.lang3.time.StopWatch

import static DataFrame.*

import spock.lang.Specification

class DataFrameTest extends Specification {

  def "Can apply closure to column values"(){

    DataFrame df = new DataFrame([
        a: [1, 2, 3]
    ])
    def result = df.apply { List<Object> vals ->
      vals.collect {
        it + 1
      }
    }

    expect:
      result.a == [2, 3, 4]
  }
}
