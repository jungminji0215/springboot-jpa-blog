let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{      // function(){} 말고 ()=>{} 사용하는 이유는, this를 바인딩하기 위해서!!
				this.save();
			});
		},
		
		save: function(){
			let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			};
			
			console.log(data);
			
			// ajax 호출 시 default가 비동기 호출
			// ajax 통신을 이용해서 3개의 데이터를 json을 변경하여 insert 요청할 것이다.
			// ajax가 통신을 성공하고 json을 리턴해주면 서버가 자동으로 자바 오브젝트로 변환해주네요?
			$.ajax({
				// 회원가입 수행 요청 응답 결과가 정상이면 done, 실패하면 fail 수행
				type: "POST",  // insert 할꺼니까 post
				url: "/blog/api/user", // 요청을 이쪽으로함
				data: JSON.stringify(data), // js 오브젝트가 JSON 문자열로 바뀜, http body 데이터
				contentType: "application/json; charset=utf-8",   // body 데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열이다 근데 생긴게 json이라면 => js 오브젝트로 변경 
				//응담의 결과가 밑에 함수의 파라미터로 전달이 됨
			}).done(function(resp){
					alert("회원가입이 완료되었습니다.");
					console.log(resp);
					location.href = "/blog";
			}).fail(function(error){
					alert(JSON.stringify(error));
			}); 
		} 	
}

index.init();