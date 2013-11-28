package com.bloidonia.tpyo

import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance

class TpyoExtension {
	private static String similar( String name, List<String> names ) {
		def best = names.inject( [ n:'', d:99999 ] ) { dist, n ->
	        def d = getLevenshteinDistance( n, name )
	        d < dist.d ? [ n: n, d: d ] : dist
	    }
	    best.n
	}

	private static decorate( self ) {
   	    self.getMetaClass().methodMissing = { name, args ->
   	    	String sim = similar( name, self.metaClass.metaMethods.name + self.metaClass.methods.name )
	        self."${sim}"( *args )
	    }
	    
	    if( self instanceof Map ) {
	        self = self.withDefault { name -> self."${similar( name, self.keySet()*.toString() )}" }
	    }
	    else {
	        self.metaClass.propertyMissing { String name ->
	        	self."${similar( name, self.metaClass.properties.name )}"
	        }
	    }
	    self
	}

	static Object tpyo( Object self ) { decorate( self ) }
}