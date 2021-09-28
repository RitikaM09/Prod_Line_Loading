import groovy.transform.Field
import java.util.List
import org.apache.commons.lang3.text.StrSubstitutor
@Field def Map<String,String> parameterMap = new LinkedHashMap<String, String>()
@Field def Map<String,String> ajexMap = new LinkedHashMap<String, String>()



  //////////////////////////////////////
def parseInputParams(def parent,params)
{
  loadProperty(parent,params)

}


////////////////////////////////////
void loadProperty(def parent,params)
{
  for (param in params) {
        String[] paramArray = param.split(":", 2)
        String key = paramArray[0]
    println "KEY : ${key}"
        if (paramArray.length == 2) {
            String value = paramArray[1]
          println "VALUE : ${value}"
            parameterMap.put(key.toString().trim(), value.toString().trim())

        } else if (paramArray.length == 1) {
            parameterMap.put(key.toString().trim(), "")
        }
  
  
  }
  println "parameterMap : ${parameterMap}"
      println "############"
      
  
      String env = parameterMap.get("environment")
      line = env.substring(0, env.indexOf("-"))
      println "LINE : ${line}"
      def TestEnv=env.substring(env.indexOf("-")+1,env.length())
      println "TestEnv : ${TestEnv}"
      
      loadJobMaps(line,"ServiceTests",ajexMap,parent)
}




////////////////////////////////////////////////////////////////////////////////
 void loadJobMaps(line, testType, testMap,def parent) {
    userDataYML = readYaml text:  'property/test.yml'
    println "userDataYML : ${userDataYML}"
    //def jobData = parent.userDataYML.(indent.toString()).(testType.toString().trim())
    //jobData = (jobData == null ? "" : jobData)
   //populateMap(jobData, testMap)
}
