package com.mk.ots.mapper;

import com.mk.ots.hotel.model.THotelModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * THotelMapper.
 * @author chuaiqing.
 *
 */
@Repository
public interface THotelMapper {
    /**
     * 根据id查询酒店
     * @param id
     * 参数：酒店id
     * @return THotelModel
     * 返回值
     */
    public THotelModel selectById(@Param("id") Long id);
    
    public List<THotelModel> findList();
    
    /**
     * 根据id查询酒店：包含酒店所属省份、区县信息
     * @param id
     * 参数：酒店id
     * @return THotelModel
     * 返回值
     */
    public THotelModel findHotelInfoById(@Param("id") Long id);

	public int updateTHotel(THotelModel thotel);
    
    public List<THotelModel> findListInfo(@Param("id") Long id);
    
    
    /**
     * @return
     * 查询所有酒店id 
     */
    public List<Long> findAllHotelIds();
    
    /**
     * @return
     * 查询指定城市所有酒店id 
     */
    public List<Long> findCityHotelIds(String citycode);
    
    public THotelModel selectByPms(String pms);
    
    public THotelModel selectByPmsAndTime(Map<String,Object> map);

	public List<Map<String, String>> selectPicsByHotelId(Long hotelid);
	
	public String getLatestOrderTime(Long hotelid);
	
	public String selectCityCodeByOrderId(Long orderId);

    /**
     * 酒店是否是新pms创建
     * @param hotelid
     * @return
     */
    public String findHotelIsNewPms(Long hotelid);
}
