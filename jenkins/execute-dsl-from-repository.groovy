import javaposse.jobdsl.plugin.ExecuteDslScripts
import hudson.model.FreeStyleProject
import hudson.plugins.git.BranchSpec
import hudson.plugins.git.GitSCM
import hudson.plugins.git.UserRemoteConfig

String gitCredentialsId = 'credentialsId'
String seedRepo = "http://mysourcecode.com/project.git"
String seedTarget = "/jenkins/sheed.groovy"


def jenkins = Jenkins.getInstance();


def remote = new UserRemoteConfig(seedRepo, null, null, gitCredentialsId)
def scm = new GitSCM(
            [remote] as List, [new BranchSpec("master")],
            false, [], null, null, [])


def seedJob = jenkins.createProject(FreeStyleProject.class, 'seed-job');
seedJob.scm = scm


def executeDslScripts = new ExecuteDslScripts()
executeDslScripts.setTargets(seedTarget)
//xecuteDslScripts.setRemovedJobAction(RemovedJobAction.DELETE)
//executeDslScripts.setRemovedViewAction(RemovedViewAction.IGNORE)
//executeDslScripts.setLookupStrategy(LookupStrategy.JENKINS_ROOT)


seedJob.buildersList << executeDslScripts
seedJob.save()

jenkins.reload()

println("===> Configuring Seed completed")