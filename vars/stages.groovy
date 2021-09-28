def initStage(def caller)
{
  def inputParameters="""component_name:wallets;
environment:d1-np;
git_repo:git@github.sie.sony.com:SIE/ca-hyperloop.git;
project_dir:property/;
testscope:Promote;
git__branch:gisc-kt;"""
  
  String [] params= inputParameters.split(";")
  
  println params
  
  util.parseInputParams(caller,params)

  
  
  
    
}
