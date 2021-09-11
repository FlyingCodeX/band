package com.xiefei.bandportal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoGenerator
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bw_music")
@ApiModel(value="Music对象", description="")
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "播放地址	")
    private String path;

    @ApiModelProperty(value = "创作者")
    private String player;

    @ApiModelProperty(value = "音乐名字")
    private String name;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "风格流派")
    private String style;

    @ApiModelProperty(value = "所属专辑")
    private String alum;


}
