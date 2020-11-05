package com.gosang.entity;

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
    public class PersonCourse implements Serializable {

    private static final long serialVersionUID=1L;

      private Integer mcId;

    private Integer usrId;

    private String mcName;

    private String mcFlag;

      @TableField(fill = FieldFill.INSERT)
      private LocalDateTime createTime;

      @TableField(fill = FieldFill.INSERT_UPDATE)
      private LocalDateTime updateTime;


}
