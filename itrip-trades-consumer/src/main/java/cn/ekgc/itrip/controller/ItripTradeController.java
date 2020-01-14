package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.base.controller.BaseController;
import cn.ekgc.itrip.base.enums.SuccessEnum;
import cn.ekgc.itrip.hotel.transport.HotelOrderTransport;
import cn.ekgc.itrip.pojo.entity.HotelOrder;
import cn.ekgc.itrip.pojo.vo.PersonalOrderRoomVO;
import cn.ekgc.itrip.pojo.vo.ResponseResult;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController("tradesController")
@RequestMapping("trade/api")
public class ItripTradeController extends BaseController {
	@Autowired
	private HotelOrderTransport hotelOrderTransport;
	@RequestMapping(value = "/prepay/{orderNo}", method = RequestMethod.GET)
	public ResponseResult<Object> payOrder(@PathVariable("orderNo") String orderNo) throws Exception {
		// 通过订单编号查找对应的订单信息
		HotelOrder hotelOrder = hotelOrderTransport.getHotelOrderByNo(orderNo);

		// 判断该订单是否存在，另外订单处于未支付状态
		if (hotelOrder != null && hotelOrder.getOrderStatus() == 0) {
			// 查询房间信息
			PersonalOrderRoomVO roomVO = hotelOrderTransport.getpersonalorderroominfo(hotelOrder.getId());
			// 该订单可以进行支付
			// 获得订单金额
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			String total_amount = decimalFormat.format(hotelOrder.getPayAmount());
			// 订单编号使用当前时间
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String out_trade_no = dateFormat.format(new Date()) + System.currentTimeMillis();
			String product_code = orderNo;
			String subject = hotelOrder.getHotelName();
			String body = roomVO.getRoomTitle() + "，" + hotelOrder.getCount() + "间，" + hotelOrder.getBookingDays() + "天";
			// 开始支付
			AlipayClient alipayClient = new DefaultAlipayClient(
					"https://openapi.alipaydev.com/gateway.do",
					"2016102100729653",
					"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDWmRUsCUoVqGST+skZZCoLUcJ26wNXf8xNq/l4m3YudCrJLF4+aJOTNoqx4P2sOY2sjWe5Ta+NQ9wMAOH776KpLlgGknTxSJzwbIDw8pYtmuyoxw921XVGMDC4SS+/MwUa4yjKmjuTMgklIazcsSwwdNm3gncC8v8dGRWZnqtARUbAnbe0WP9azGMA1jMUYgNlvLiXwrhqxZG3HHSY41STqH0pbjnOTnP5mG0gWlcPC+U15tUtNAF9wjdXrKP1Wqw7KwuXohKpwQFo/feM+Lf7qAcpx9Sutn7bv5AKN/yWF4pw42Fb/rTXNZF9OX+fsGjG/XZLz0LtJsqQ9UJPIp6VAgMBAAECggEAMZ8AKEiVmuBvMVCCA58Hocpr/vdktGzWnvcvHlZEQ4WVByN9P00LIrUv6OWvgo1kVwvzegOenjmcviHOH2VP5XLT4+ElrU0vDODqB8zwMOdr5bLxvnapQWuPOG2j3sA7Y/Y2znJPaD/foXhh8j39i87ZMPe38TSjDOVp+zWXP6rYaO+onnd7mJWdBdgcJMIzYXn7bjHa48eNKPYPTq0bSaL+y3wmqpJn0NjIswCGLwW+I9+EUA/L0wH0ruwhqWMWDZoU0jaakzCYSDrGcK7j2jIMSSzdOCnnVlTy34Wj5pLpE4OxPIEVuhITl4dbxIgS0fkOXxwIi2FuU9kOgD2sAQKBgQD+Z+roI4CLMU6XtUhpIO07sQImOtIxqWsaVJfR0nO161DxzY3+kQUFMVQNCmfqlyNf/jncgV9yuGOM5FCcolBtchLq13B6Z3rp6mzn1s7N/ixypXRvWSc4eAmYzKSkvXo4EmQBPwlkM2aPEoPgKc93mbn7G8+soIHOejQPCp5VFQKBgQDX8U+Nv2bLiGCKq7mK5Asx76EdfiFDDatnH/jSrAINBoADZOGDQooX7hBiuYU0sdHL1nGsSYKGrrPqDkGy97yDFxI1SbbeeHs2h70bi8XlpaxkuODJFpi1tj8NBlwcrrSj7Ca1A+Ie0bGnmwIPS6X2PnaG101V6YyYiEmfxJCDgQKBgQCV6fCgCMOnwk940IeyA4goY59Lnd/dCeOmKXEpYKV07wzM4H8rIpPdwnqwEJC5yYQ7/dhk2wu+028+SBBErNVOGSmSn4+VYcMpck3otEk7U+snR957+wJEoV+uXfErbshFoHizz0yecjeeWZ/CiYDLDphso6/WHuM/I/3nWy+AHQKBgEP/k9qB4//BcQ0ZqDKJPtE5sRVVa2nu+wNdOQA18+tgGZ13/d9Ua6G/cF92JfEC8Zpra54iA70fdD4GwT927WCmOjCXhsMlUz9HnQ/4gpefBNsusHIB8JJ/0fjrAMRzaySXL1Ue5OxpgbTSheKFIryYzMAHOi4Mfh5mBDEQN6WBAoGAfxxbgaVA3ibfWLXFhQU2E2qh3Lh03yt5Xg9ky0xl3Vnkw2pZuDXD/YWO200CclhUzhoVVos3CVnmX9eTzGHMIAcsbmTzwro9OiOg6LLdNysFBuwobVLyIz/6Bk4kCWqUx2avlZbbUm1917v83bgSQeHuS9DiZSXfyQWzyxfZMwg=",
					"json",
					"UTF-8",
					"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlvlrUZQLfXsmmKgdBK5hyDEL2arw/y7dtngcDVCIR0yEu+KCAGYgzOYgm13Bgorvp8Of9aahHHhRPX5GhzzD9WKzRLOV7anVopfV3n+ZRNM7gt7eWdDD7k/nRGz5NB7u/COCtQijx30tXpr2nwxOe+A1DnTuuT7VgpLCVovKPFTUlcsmZhHzVpL5sRxVHBVb90VhW7Vo1J50nYwFSGpLxly1jVzy2GCVmLMc36EvFeBrGpHl4fkZDKyHvoY2ak7a0bQExeJkWv/Xln5Jc+OSr3tjMN1pbaaxwH8d1mO9vVuXthyejygpb5HLgucNhzdtaF8gR/aa0h3pH+UVUtIxfwIDAQAB",
					"RSA2"
			); //获得初始化的AlipayClient
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
			alipayRequest.setReturnUrl("http://localhost/itrip");
			alipayRequest.setNotifyUrl("http://itrip.project.bdqn.cn/trade/api/notify/" + hotelOrder.getId());
			//在公共参数中设置回跳和通知地址
//在公共参数中设置回跳和通知地址

			String json = "{\"out_trade_no\":\"" + out_trade_no
					+ "\", \"product_code\":\"FAST_INSTANT_TRADE_PAY\", "
					+ "\"total_amount\":\"" + total_amount
					+ "\",\"subject\":\"" + subject
					+ "\",\"body\":\"" + body + "\","
					+ "\"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\",\"extend_params\":{}}";
			System.out.println(json);

			alipayRequest.setBizContent(json);//填充业务参数

			String form="";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(form);//直接将完整的表单html输出到页面
			response.getWriter().flush();
			response.getWriter().close();
		}
		return new ResponseResult<>(SuccessEnum.SUCCESS_TRUE);
	}
}
