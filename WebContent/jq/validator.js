$(document).ready(
		function() {
			$("form").submit(
					function(event) {
						var formData = {
							vehicalBrand : $("#vehicalBrand").val(),
							vehicalModel : $("#vehicalModel").val(),
							modelYear : $("#modelYear").val(),
							vehicalCount : $("#vehicalCount").val()
						};

						$.ajax({
							type : "POST",
							url : "VehiceServelet",
							data : formData,
							dataType : "json",
							encode : true,
						}).done(
								function(v) {
									console.log(v);
									if (!v.success) {
										if (!v.vehicalBrand) {
											//
											// $("#name-group").addClass("has-error");
											// // $("#name-group").append(
											// // '<div style="color: red" >' +
											// v.vehicalBrand + "</>"
											// // );

											$("#vehicalBrand").addClass("input-error");
//											 $("#name-group").append(
//											 '<div style="color: red" >' + "Enter the " + "</>");
										} else {
											$("#vehicalBrand").removeClass("input-error");
										}

										if (!v.vehicalModel) {
											$("#vehicalModel").addClass("input-error");
										} else {
											$("#vehicalModel").removeClass("input-error");
										}
										
										if (!v.modelYear) {
											$("#modelYear").addClass("input-error");
										} else {
											$("#modelYear").removeClass("input-error");
										}
										
										if (!v.vehicalCount) {
											$("#vehicalCount").addClass("input-error");
										} else {
											$("#vehicalCount").removeClass("input-error");
										}

									} else {
										$("#vehicalModel").removeClass("input-error");
										$("#vehicalBrand").removeClass("input-error");
										$("#modelYear").removeClass("input-error");
										$("#vehicalCount").removeClass("input-error");
										$("#name-alert").append(
												'<div class="alert alert-success">'
														+ "Success" + "</>");
										
										$("#vehicalModel").val("");
										$("#vehicalBrand").val("");
										$("#modelYear").val("");
										$("#vehicalCount").val("");
									}

								});
						event.preventDefault();
					});

		});