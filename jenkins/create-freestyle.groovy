#!groovy

import jenkins.model.Jenkins;
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import hudson.triggers.SCMTrigger;

def jenkins = Jenkins.getInstance();
def initJob = jenkins.createProject(WorkflowJob.class, 'init-job');

initJob.setDescription('This is a dummy project');