package runnable

import reader.GroovyReader
import runnable.common.AbstractRunner
import writer.FactoryWriter
import writer.PrintClassStatement

class RBS extends AbstractRunner {

    public void run() {

        abstractReader = new GroovyReader()

        File folder = new File('/Users/diegio/Documents/Pollux  & Castor/AtaxiaDoLadoEsquerdo - RBS/src/simulation/beats/SimulationClassBeats1.groovy')

        explore(folder)
        folder.listFiles().each {
            explore(it)
        }

        abstractReader.classStatements.each {
            PrintClassStatement.print(it)
        }

        FactoryWriter factoryWriter = new FactoryWriter()
        abstractReader.classStatements.each {
//            println factoryWriter.writeBuildFunction(it)
//
//            println ''
//
//            println factoryWriter.writeCreateFunction(it)
        }

    }

}