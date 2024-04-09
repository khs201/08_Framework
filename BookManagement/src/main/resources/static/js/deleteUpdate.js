const tbody = document.querySelector("tbody");

fetch("/search")
  .then(response => response.json())
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
      // 수정 버튼 추가
      const editBtn = document.createElement("button");
      editBtn.innerText = "수정";
      editBtn.onclick = () => {
        // 수정 기능 구현
        


      };

      const tdEdit = document.createElement("td");
      tdEdit.append(editBtn);
      tr.append(tdEdit);

      // 삭제 버튼 추가
      const deleteBtn = document.createElement("button");
      deleteBtn.innerText = "삭제";
      deleteBtn.onclick = () => {
        // 삭제 기능 구현
        if (!confirm("정말 삭제할꺼임?")){
          
          return;
        }
        
        const bookNo = detail[bookNo];
        console.log(bookNo);

        
      };

      const tdDelete = document.createElement("td");
      tdDelete.append(deleteBtn);
      tr.append(tdDelete);



      // tbody의 자식으로 tr (한 줄) 추가
      tbody.append(tr);
    }






  }
  )

const searchBtn = document.querySelector("#searchBtn").addEventListener("click", () => {

  const searchBookName = document.querySelector("#searchBookName").value;

  tbody.innerHTML = "";

  fetch(`/deleteUpdate/detailSearch?searchBookName=${searchBookName}`)
    .then(response => response.json())
    .then(result => {

      for (let details of result) {


        const tr = document.createElement("tr");

        const arr = ['bookNo', 'bookTitle', 'bookWriter', 'bookPrice', 'regDate'];

        for (let key of arr) {

          const td = document.createElement("td");

          td.innerText = details[key];
          tr.append(td);
        }
        // tbody의 자식으로 tr (한 줄) 추가
        tbody.append(tr);


      }

    })


})

