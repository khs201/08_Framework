const totalCount = document.querySelector("#totalCount");
const completeCount = document.querySelector("#completeCount");

// 전체 Todo 개수 조회 및 출력하는 함수

function getTotalCount() { // 함수 정의


  // 비동기로 서버(DB)에서 전체 Todo 개수 조회하는
  // fetch() API 코드 작성
  // (fetch : 가지고 오다)

  fetch("/ajax/totalCount") // 비동기 요청 수행 -> Promise 객체 반환
  .then(response => {

    // response : 비동기 요청에 대한 응답이 담긴 객체

    // response.text() : 응답 데이터를 문자열/숫자 형태로 변환한
    //                   결과를 가지는 Promise 객체 반환

    console.log(response);
    // console.log(response.text());

    return response.text();

  })

  // 두 번째 then의 매개 변수(result)
  // == 첫 번째 then에서 반환된 Promise 객체의 PromiseResult 값
  .then(result => {
    console.log("result", result);

  })

  // totalCount 요소의 내용을 20으로 변경
  totalCount.innerText = 20;
}

// getTotalCount() 함수 호출