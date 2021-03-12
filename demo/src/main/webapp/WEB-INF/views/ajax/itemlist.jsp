<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>CODE</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>QUANTITY</th>
                <th>REGDATE</th>
                <th>CATEGORY</th>
            </tr>
        </thead>
        <tbody>
            
        </tbody>
    </table>
    
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js" type="text/javascript"></script>
      <script type="text/javascript">
        $(function(){
            // {ret: 1, data: Array(10)}
            $.get('http://127.0.0.1:9092/ROOT/item/list.json?start=1&end=3&type=code&text=', function(res){
                console.log(res);
                if(res.ret == 1) {
                    const data = res.data;
                    for(let i=0;i<data.length; i++) {
                        // {code: 53, name: "BBD", price: 15000, quantity: 200, regdate: "2021-03-10 15:11:42.0", …}
                        console.log(data[i].code,data[i].name);
                        $("tbody").append(
                          '<tr>'    +
                                '<td>' + data[i].code + '</td>' +
                                '<td>' + data[i].name + '</td>' +
                                '<td>' + data[i].price + '</td>' +
                                '<td>' + data[i].quantity + '</td>' +
                                '<td>' + data[i].regdate + '</td>' +
                                '<td>' + data[i].category + '</td>' +
                            '</tr>'
                        );
                    }
                }
            },'json');
        });
    </script>
</body>
</html>