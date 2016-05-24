# PVC demo

This example shows how to use a PVC. 

### Building

The example can be built with

    mvn clean fabric8:json compile fabric8:apply

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

