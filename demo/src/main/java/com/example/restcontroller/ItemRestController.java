package com.example.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.ItemMapper;
import com.example.vo.ItemVO;

@RestController
@CrossOrigin("*") //json파일을 front개발자에게 보내기 위해 access를 풀어준다.
@RequestMapping(value="/item")
public class ItemRestController {

	@Autowired
	ItemMapper itemMapper;
	
	@RequestMapping(value="/list.json",
			method={RequestMethod.POST,RequestMethod.GET})
	public Map<String, Object> list(
			@RequestParam(value="start") int start,
			@RequestParam(value="end") int end,
			@RequestParam(value="type") String type,
			@RequestParam(value="text") String text) {

		List<ItemVO> list = itemMapper.selectItemList(1, 10, "code", "");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret", 1);
		map.put("data", list);
		return map;
	}
	
	@RequestMapping(value="/insert.json",
			method= {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> insert(
			@RequestParam(value="code") long code,
			@RequestParam(value="name") String name,
			@RequestParam(value="price") long price,
			@RequestParam(value="quantity") long quantity,
			@RequestParam(value="category") String category) {
		Map<String,Object> map = new HashMap<String,Object>();
		
		ItemVO vo = new ItemVO();
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setQuantity(quantity);
		vo.setCategory(category);
		
		itemMapper.insertItemOne(vo);
		map.put("ret", 1);
		return map;
	}
	
	@RequestMapping(value="/insert1.json",
			method= {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> insert1(
			@RequestBody ItemVO vo) {
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(vo.toString());
		itemMapper.insertItemOne(vo);
		map.put("ret", 1);
		return map;
	}
	
	@RequestMapping(value="/chart.json", method = {RequestMethod.GET, RequestMethod.POST} )
	public Map<String, Object> chart(){
		int a = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int b = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int c = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int d = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int e = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int f = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		
		int a1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int b1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int c1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int d1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int e1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int f1 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		
		int a2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int b2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int c2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int d2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int e2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		int f2 = new Random().nextInt(1000) + 1; //1~1000사이의 숫자
		
		//['data1', 30,200,100,400,150,250],
		String data1 = String.format("['data1', %d, %d, %d, %d, %d, %d]",a,b,c,d,e,f); 
		String data2 = String.format("['data2', %d, %d, %d, %d, %d, %d]",a1,b1,c1,d1,e1,f1); 
		String data3 = String.format("['data3', %d, %d, %d, %d, %d, %d]",a2,b2,c2,d2,e2,f2); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", 1);
		map.put("data1", data1);
		map.put("data2", data2);
		map.put("data3", data3);
		return map;
	}
	
}
