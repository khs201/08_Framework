const searchBtn = document.querySelector("#searchBtn");
const tbody = document.querySelector("tbody");

searchBtn.addEventListener("click", () => {

  //console.log("확인");

  fetch("/search")
    .then(response =>  response.json())
    .then(result => {
    

      const bookList = result;

      tbody.innerHTML = "";

      for (let detail of bookList) { // 향상된 for문

        // tr 태그 생성

        const tr = document.createElement("tr");


        const arr = ['bookNo', 'bookTitle', 'bookWriter', 'bookPrice', 'regDate'];

        for (let key of arr) {

          const td = document.createElement("td");

         
          td.innerText = detail[key];
          tr.append(td);
        }
        // tbody의 자식으로 tr (한 줄) 추가
        tbody.append(tr);


      }




    }
    )


    

});