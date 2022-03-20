import jenkins.model.*

def j = Jenkins.getInstance();

if(!j.isQuietingDown()) {
    def job_dsl_security = j.getExtensionList('javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration')[0]
    if(job_dsl_security.useScriptSecurity) {
        job_dsl_security.useScriptSecurity = false
        println 'Job DSL script security has changed.  It is now disabled.'
        job_dsl_security.save()
        j.save()
    }
    else {
        println 'Nothing changed.  Job DSL script security already disabled.'
    }
}
else {
    println 'Shutdown mode enabled.  Configure Job DSL script security SKIPPED.'
}