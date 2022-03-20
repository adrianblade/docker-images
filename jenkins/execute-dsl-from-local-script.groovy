import javaposse.jobdsl.plugin.ExecuteDslScripts
import hudson.model.FreeStyleProject
import jenkins.model.*


def jenkins = Jenkins.getInstance();
def seedJob = jenkins.createProject(FreeStyleProject.class, 'seed-job');
seedJob.description = "Run this job only once to create other jobs using Job-DSL plugin."
def seedJobsStep = new ExecuteDslScripts()

seedJobsStep.scriptText = """
multibranchPipelineJob('app1') {
    branchSources {
        git {
            id = 'app1'
            remote('https://git/scm/project/app1.git')
        }
    }
}

multibranchPipelineJob('app2') {
    branchSources {
        git {
            id = 'app2'
            remote('https://git/scm/project/app2.git')
        }
    }
}

multibranchPipelineJob('app3') {
    branchSources {
        git {
            id = 'app3'
            remote('https://git/scm/project/app3.git')
        }
    }
}
"""
seedJob.buildersList << seedJobsStep
seedJob.save()

jenkins.reload()