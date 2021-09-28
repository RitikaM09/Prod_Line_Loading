import groovy.transform.Field

@Field def Map<String,String> parameterMap = new LinkedHashMap<String, String>()
import java.util.List
import org.apache.commons.lang3.text.StrSubstitutor


def parseInputParams(def parent,params)
{
  loadProperty(parent,params)

}



void loadProperty(def parent,params)
{
  for (param in params) {
        String[] paramArray = param.split(":", 2)
        String key = paramArray[0]
        if (paramArray.length == 2) {
            String value = paramArray[1]
            println value
            parent.parameterMap.put(key.toString().trim(), value.toString().trim())
        } else if (paramArray.length == 1) {
            parent.parameterMap.put(key.toString().trim(), "")
        }
  
  
  }
  
      println "############"
      println parameterMap
  
  
}

