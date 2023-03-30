import request from '@/utils/request'

// 查询巡更点管理列表
export function listPoint(query) {
  return request({
    url: '/system/point/list',
    method: 'get',
    params: query
  })
}

// 查询巡更点管理详细
export function getPoint(patrolPointId) {
  return request({
    url: '/system/point/' + patrolPointId,
    method: 'get'
  })
}

// 新增巡更点管理
export function addPoint(data) {
  return request({
    url: '/system/point',
    method: 'post',
    data: data
  })
}

// 修改巡更点管理
export function updatePoint(data) {
  return request({
    url: '/system/point',
    method: 'put',
    data: data
  })
}

// 删除巡更点管理
export function delPoint(patrolPointId) {
  return request({
    url: '/system/point/' + patrolPointId,
    method: 'delete'
  })
}