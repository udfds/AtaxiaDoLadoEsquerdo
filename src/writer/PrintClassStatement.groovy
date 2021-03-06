package writer

import statement.ClassStatement
import statement.StaticScopeStatement

/**
 * Created by dfds on 10/8/17.
 */
class PrintClassStatement {

    public static void print(ClassStatement classStatement) {

        println ''
        println classStatement.name

        classStatement.imports.each {
            println '   import: ' + it
        }

        if (classStatement.extendsClass) {
            println '   extend: ' + classStatement.extendsClass.name
        }

        classStatement.implementsInterfaces.each {
            println '   implements: ' + it.name
        }

        classStatement.internalEnumerations.each {
            println '   enum: ' + it.name
        }

        classStatement.properties.each {
            println '   ' + it.type + ' ' + it.name + (it.isBelongsTo ? ' (BelongsTo) ' : '') +
                    (it.isHasMany ? ' (HasMany) ' : '') + (it.isHasOne ? ' (HasOne) ' : '') +
                    (it.isTransient ? ' (Transient) ' : '') +  ' = ' + it.defaultValue + " (${it.visibility})"
        }

        classStatement.functions.each {
            println '   -F: ' + it.type + ' ' + it.name + (it.isStatic ? ' (static) ' : '') + " (${it.visibility})"
            it.arguments.each { arg ->
                println '       -- ' + arg.name + ' = ' + arg.defaultValue
            }
            it.exceptions.each { exp ->
                println '       -- EXP: ' + exp
            }
        }

        classStatement.closures.each {
            if (it.isAnonymous) {
                println '   -C: anonymous closure ' + (it.isStatic ? ' (static) ' : '')
            } else {
                println '   -C: ' + it.type + ' ' + it.name
            }
        }

        classStatement.staticScopes.eachCombination { StaticScopeStatement staticScopeStatement ->
            println '   -SSS: ' + staticScopeStatement.content.substring(0, 6)
        }

        println ''

    }

}
