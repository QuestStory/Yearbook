import request from '@/utils/request'

// 查询留言条列表
export function listTagboard(query) {
  return request({
    url: '/yearbook/tagboard/list',
    method: 'get',
    params: query
  })
}

// 查询留言条详细
export function getTagboard(id) {
  return request({
    url: '/yearbook/tagboard/' + id,
    method: 'get'
  })
}

// 新增留言条
export function addTagboard(data) {
  return request({
    url: '/yearbook/tagboard',
    method: 'post',
    data: data
  })
}

// 修改留言条
export function updateTagboard(data) {
  return request({
    url: '/yearbook/tagboard',
    method: 'put',
    data: data
  })
}

// 删除留言条
export function delTagboard(id) {
  return request({
    url: '/yearbook/tagboard/' + id,
    method: 'delete'
  })
}
