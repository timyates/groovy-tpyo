## groovy-tpyo
==============

### A Groovy Homage to https://github.com/mathiasbynens/tpyo

Levenshtein Distances, methodMissing and defaults, oh my!

Please see [known issues](https://github.com/timyates/groovy-tpyo#known-issues) below.

```groovy
@GrabResolver( name='sona', root='https://oss.sonatype.org/content/repositories/snapshots' )
@Grab( 'com.bloidonia:groovy-tpyo:1.0-SNAPSHOT' )

def list = [ 1, 2, 3 ].tpyo()

assert list.size() == 3
assert list.siez() == 3
assert list.finDAll { it % 2 } == [ 1, 3 ]
assert list.findAll { it % 2 } == [ 1, 3 ]

def map = [ name:'tim' ].tpyo()

assert map.name == 'tim'
assert map.nAm3 == 'tim'
assert map.naem == 'tim'

// maps get corrupted atm :-(
assert map == [ name:'tim', nAm3:'tim', naem:'tim' ]

class Person {
    String name
    String occupation
    String toString() { "$name" }
}

def p = new Person( name:'tim', occupation:'code juggler' ).tpyo()

assert p.occuption == 'code juggler'
assert p.tostr1ng() == 'tim'
```

## Known issues.

- Maps get corrupted
- Will not work with deep hierarchies.
- Will not work with `Map.withDefault`.
- Should (obviously) never be used.