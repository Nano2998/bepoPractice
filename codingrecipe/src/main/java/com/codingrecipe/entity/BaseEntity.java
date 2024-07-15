package com.codingrecipe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 생성 시간을 만들어 주는 부분
    @Column(updatable = false) // 수정시에는 관여 안함
    private LocalDateTime createdTime;

    @UpdateTimestamp // 업데이트 시간을 만들어 주는 부분
    @Column(insertable = false) // 입력시에는 관여 안함
    private LocalDateTime updatedTime;
}
