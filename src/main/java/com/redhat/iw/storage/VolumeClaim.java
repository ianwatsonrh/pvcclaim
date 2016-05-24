package com.redhat.iw.storage;

import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimVolumeSource;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ReplicationControllerSpecBuilder;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.generator.annotation.KubernetesModelProcessor;
import io.fabric8.kubernetes.generator.annotation.KubernetesProvider;

@KubernetesModelProcessor
public class VolumeClaim {

	public void on(ReplicationControllerSpecBuilder builder) {
		
		builder.editTemplate()
					.withNewSpec()
						.addNewContainerLike(builder.getTemplate().getSpec().getContainers().get(0))
							.addNewVolumeMount()
								.withName("sample")
								.withMountPath("/tmp/input")
							.endVolumeMount()
						.endContainer()
						/*	
						.withContainers(builder.getTemplate().getSpec().getContainers())
							.addNewVolume()
								.withNewPersistentVolumeClaim()
									.withClaimName("claim1")
								.endPersistentVolumeClaim()
							.endVolume()
							*/
						
						
						.addNewVolume()
							.withName("sample")
							.withNewPersistentVolumeClaim()
								.withClaimName("claim1")
							.endPersistentVolumeClaim()
						.endVolume()
					.endSpec()
				.endTemplate();
	}
	
	

}
