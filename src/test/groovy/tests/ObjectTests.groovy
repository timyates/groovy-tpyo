/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests

class ObjectTests extends spock.lang.Specification {

	class Person {
		String name
		int    age
	}

	def 'object tests'() {
		setup:
		    def data = [ new Person( name: 'tim', age: 86 ),
		                 new Person( name: 'alice', age: 43 ),
		                 new Person( name: 'dave', age: 62 ) ]

		    data*.tpyo()
		expect:
            assert data*.name == [ 'tim', 'alice', 'dave' ]
            assert data*.naem == [ 'tim', 'alice', 'dave' ]
            assert data*.aeg  == [ 86, 43, 62 ]
            assert data*.ag   == [ 86, 43, 62 ]
	}
}