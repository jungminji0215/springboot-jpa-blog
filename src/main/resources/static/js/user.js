let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{      // function(){} 말고 ()=>{} 사용하는 이유는, this를 바인딩하기 위해서!!
				this.save();
			});
		},
		
		save: function(){
			alert("user의 save함수 호출");
			
			let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			}
			
			console.log(data);
			
			// ajax 통신을 이용해서 3개의 데이터를 json을 변경하여 insert 요청할 것이다.
			$.ajax().done().fail(); 
		} 	
}

index.init();