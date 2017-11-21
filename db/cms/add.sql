#相册表
CREATE TABLE `cms_album` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `category_id` varchar(64) NOT NULL COMMENT '栏目编号',
  `image_address` varchar(255) DEFAULT NULL COMMENT '图片地址  一个数组',
  `album_name` varchar(255) DEFAULT NULL COMMENT '相册名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `hits` int(11) DEFAULT NULL COMMENT '点击量',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#视频表
CREATE TABLE `cms_video` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `category_id` varchar(64) NOT NULL COMMENT '栏目编号',
  `video_address` varchar(255) DEFAULT NULL COMMENT '视频链接地址',
  `video_name` varchar(255) DEFAULT NULL COMMENT '视频名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `hits` int(11) DEFAULT NULL COMMENT '点击量',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标志',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;