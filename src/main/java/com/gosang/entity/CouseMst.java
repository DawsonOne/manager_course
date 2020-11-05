package com.gosang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gosang
 * @since 2020-11-04
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class CouseMst implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "cid", type = IdType.AUTO)
      private Integer cid;

    private String cname;

    private String cperiod;

    private String cdescription;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private LocalDateTime updateTime;


}
