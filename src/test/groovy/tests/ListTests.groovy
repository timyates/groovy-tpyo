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

class ListTests extends spock.lang.Specification {
	def 'list tests'() {
		setup:
		    def list = ['a', 'b', 'c'].tpyo()
		expect:
            assert list.toString() == '[a, b, c]'
            assert list.tosTring() == '[a, b, c]'
            assert list.t0String() == '[a, b, c]'
            assert list.toStrong() == '[a, b, c]'
	}
}